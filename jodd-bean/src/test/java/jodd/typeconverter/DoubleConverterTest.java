// Copyright (c) 2003-present, Jodd Team (http://jodd.org)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package jodd.typeconverter;

import jodd.typeconverter.impl.DoubleConverter;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DoubleConverterTest {

	@Test
	public void testConversion() {
		DoubleConverter doubleConverter = new DoubleConverter();

		assertNull(doubleConverter.convert(null));

		assertEquals(Double.valueOf(1), doubleConverter.convert(Integer.valueOf(1)));
		assertEquals(Double.valueOf(1.73), doubleConverter.convert(Double.valueOf(1.73D)));
		assertEquals(Double.valueOf(1.73), doubleConverter.convert("1.73"));
		assertEquals(Double.valueOf(1.73), doubleConverter.convert(" 1.73 "));
		assertEquals(Double.valueOf(1.73), doubleConverter.convert(" +1.73 "));
		assertEquals(Double.valueOf(-1.73), doubleConverter.convert(" -1.73 "));
		assertEquals(Double.valueOf(1.73), doubleConverter.convert(new BigDecimal("1.73")));

		try {
			doubleConverter.convert("aaaa");
			fail();
		} catch (TypeConversionException ignore) {
		}
	}
}
