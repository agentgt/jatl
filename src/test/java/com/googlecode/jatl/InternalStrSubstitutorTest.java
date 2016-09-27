/**
 * Copyright (C) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.jatl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test class for InternalStrSubstitutor.
 * Copied from commons lang.
 */
public class InternalStrSubstitutorTest {

    private Map<String, String> values;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("animal", "quick brown fox");
        values.put("target", "lazy dog");
    }

    @After
    public void tearDown() throws Exception {
        values = null;
    }

    //-----------------------------------------------------------------------
    /**
     * Tests simple key replace.
     */
    @Test
    public void testReplaceSimple() {
        doTestReplace("The quick brown fox jumps over the lazy dog.", "The ${animal} jumps over the ${target}.", true);
    }

    /**
     * Tests simple key replace.
     */
    @Test
    public void testReplaceSolo() {
        doTestReplace("quick brown fox", "${animal}", false);
    }

    /**
     * Tests replace with no variables.
     */
    @Test
    public void testReplaceNoVariables() {
        doTestNoReplace("The balloon arrived.");
    }

    /**
     * Tests replace with null.
     */
    @Test
    public void testReplaceNull() {
        doTestNoReplace(null);
    }

    /**
     * Tests replace with null.
     */
    @Test
    public void testReplaceEmpty() {
        doTestNoReplace("");
    }

    /**
     * Tests key replace changing map after initialization (not recommended).
     */
    @Test
    public void testReplaceChangedMap() {
        final InternalStrSubstitutor sub = new InternalStrSubstitutor(values);
        values.put("target", "moon");
        assertEquals("The quick brown fox jumps over the moon.", sub.replace("The ${animal} jumps over the ${target}."));
    }

    /**
     * Tests unknown key replace.
     */
    @Test
    public void testReplaceUnknownKey() {
        doTestReplace("The ${person} jumps over the lazy dog.", "The ${person} jumps over the ${target}.", true);
        //I'm not sure I understand how the falling is supposed to happen
        //doTestReplace("The ${person} jumps over the lazy dog. 1234567890.", "The ${person} jumps over the ${target}. ${undefined.number:-1234567890}.", true);
    }

    /**
     * Tests adjacent keys.
     */
    @Test
    public void testReplaceAdjacentAtStart() {
        values.put("code", "GBP");
        values.put("amount", "12.50");
        final InternalStrSubstitutor sub = new InternalStrSubstitutor(values);
        assertEquals("GBP12.50 charged", sub.replace("${code}${amount} charged"));
    }

    /**
     * Tests adjacent keys.
     */
    @Test
    public void testReplaceAdjacentAtEnd() {
        values.put("code", "GBP");
        values.put("amount", "12.50");
        final InternalStrSubstitutor sub = new InternalStrSubstitutor(values);
        assertEquals("Amount is GBP12.50", sub.replace("Amount is ${code}${amount}"));
    }

    /**
     * Tests simple recursive replace.
     */
    @Ignore // recursive is not supported right now.
    @Test
    public void testReplaceRecursive() {
        values.put("animal", "${critter}");
        values.put("target", "${pet}");
        values.put("pet", "${petCharacteristic} dog");
        values.put("petCharacteristic", "lazy");
        values.put("critter", "${critterSpeed} ${critterColor} ${critterType}");
        values.put("critterSpeed", "quick");
        values.put("critterColor", "brown");
        values.put("critterType", "fox");
        doTestReplace("The quick brown fox jumps over the lazy dog.", "The ${animal} jumps over the ${target}.", true);

        values.put("pet", "${petCharacteristicUnknown:-lazy} dog");
        doTestReplace("The quick brown fox jumps over the lazy dog.", "The ${animal} jumps over the ${target}.", true);
    }

    /**
     * Tests escaping.
     */
    @Test
    public void testReplaceEscaping() {
        doTestReplace("The ${animal} jumps over the lazy dog.", "The $${animal} jumps over the ${target}.", true);
    }

    /**
     * Tests escaping.
     */
    @Test
    public void testReplaceSoloEscaping() {
        doTestReplace("${animal}", "$${animal}", false);
    }

    /**
     * Tests complex escaping.
     */
    @Test
    public void testReplaceComplexEscaping() {
        doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true);
        //Still not sure what the weird number stuff is
        //doTestReplace("The ${quick brown fox} jumps over the lazy dog. ${1234567890}.", "The $${${animal}} jumps over the ${target}. $${${undefined.number:-1234567890}}.", true);
    }

    /**
     * Tests when no prefix or suffix.
     */
    @Test
    public void testReplaceNoPrefixNoSuffix() {
        doTestReplace("The animal jumps over the lazy dog.", "The animal jumps over the ${target}.", true);
    }

    /**
     * Tests when no incomplete prefix.
     */
    @Test
    public void testReplaceIncompletePrefix() {
        doTestReplace("The {animal} jumps over the lazy dog.", "The {animal} jumps over the ${target}.", true);
    }

    /**
     * Tests when prefix but no suffix.
     */
    @Test
    public void testReplacePrefixNoSuffix() {
        doTestReplace("The ${animal jumps over the ${target} lazy dog.", "The ${animal jumps over the ${target} ${target}.", true);
    }

    /**
     * Tests when suffix but no prefix.
     */
    @Test
    public void testReplaceNoPrefixSuffix() {
        doTestReplace("The animal} jumps over the lazy dog.", "The animal} jumps over the ${target}.", true);
    }

    /**
     * Tests when no variable name.
     */
    @Test
    public void testReplaceEmptyKeys() {
        doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true);
        doTestReplace("The animal jumps over the lazy dog.", "The ${:-animal} jumps over the ${target}.", true);
    }

    /**
     * Tests replace creates output same as input.
     */
    @Ignore("recursion not supported")
    @Test
    public void testReplaceToIdentical() {
        values.put("animal", "$${${thing}}");
        values.put("thing", "animal");
        doTestReplace("The ${animal} jumps.", "The ${animal} jumps.", true);
    }

    /**
     * Tests a cyclic replace operation.
     * The cycle should be detected and cause an exception to be thrown.
     */
    @Ignore("recursion not supported")
    @Test
    public void testCyclicReplacement() {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("animal", "${critter}");
        map.put("target", "${pet}");
        map.put("pet", "${petCharacteristic} dog");
        map.put("petCharacteristic", "lazy");
        map.put("critter", "${critterSpeed} ${critterColor} ${critterType}");
        map.put("critterSpeed", "quick");
        map.put("critterColor", "brown");
        map.put("critterType", "${animal}");
        InternalStrSubstitutor sub = new InternalStrSubstitutor(map);
        try {
            sub.replace("The ${animal} jumps over the ${target}.");
            fail("Cyclic replacement was not detected!");
        } catch (final IllegalStateException ex) {
            // expected
        }

        // also check even when default value is set.
        map.put("critterType", "${animal:-fox}");
        sub = new InternalStrSubstitutor(map);
        try {
            sub.replace("The ${animal} jumps over the ${target}.");
            fail("Cyclic replacement was not detected!");
        } catch (final IllegalStateException ex) {
            // expected
        }
    }

    /**
     * Tests interpolation with weird boundary patterns.
     */
    @Test
    public void testReplaceWeirdPattens() {
        doTestNoReplace("");
        doTestNoReplace("${}");
        doTestNoReplace("${ }");
        doTestNoReplace("${\t}");
        doTestNoReplace("${\n}");
        doTestNoReplace("${\b}");
        doTestNoReplace("${");
        doTestNoReplace("$}");
        doTestNoReplace("}");
        doTestNoReplace("${}$");
        doTestNoReplace("${${");
        doTestNoReplace("${${}}");
        doTestNoReplace("${$${}}");
        doTestNoReplace("${$$${}}");
        doTestNoReplace("${$$${$}}");
        doTestNoReplace("${${}}");
        doTestNoReplace("${${ }}");
    }


    private void doTestNoReplace(final String replaceTemplate) {
        final InternalStrSubstitutor sub = new InternalStrSubstitutor(values);

        if (replaceTemplate == null) {
            assertEquals(null, sub.replace((String) null));

        } else {
            assertEquals(replaceTemplate, sub.replace(replaceTemplate));
            final StringBuilder bld = new StringBuilder(replaceTemplate);
            //assertFalse(sub.replaceIn(bld));
            assertEquals(replaceTemplate, bld.toString());
        }
    }


    @Test
    public void testSubstituteNoPreserveEscape() {
        final String org = "${not-escaped} $${escaped}";
        final Map<String, String> map = new HashMap<String, String>();
        map.put("not-escaped", "value");

        InternalStrSubstitutor sub = new InternalStrSubstitutor(map);
        assertEquals("value ${escaped}", sub.replace(org));

    }

    //-----------------------------------------------------------------------
    private void doTestReplace(final String expectedResult, final String replaceTemplate, final boolean substring) {
        final InternalStrSubstitutor sub = new InternalStrSubstitutor(values);
        assertEquals(expectedResult, sub.replace(replaceTemplate));
        
    }
}