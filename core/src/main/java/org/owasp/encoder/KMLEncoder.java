// Copyright (c) 2012 Jeff Ichnowski
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
//
//     * Redistributions of source code must retain the above
//       copyright notice, this list of conditions and the following
//       disclaimer.
//
//     * Redistributions in binary form must reproduce the above
//       copyright notice, this list of conditions and the following
//       disclaimer in the documentation and/or other materials
//       provided with the distribution.
//
//     * Neither the name of the OWASP nor the names of its
//       contributors may be used to endorse or promote products
//       derived from this software without specific prior written
//       permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
// INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.
package org.owasp.encoder;

import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/**
 * KMLEncoder -- Special case of XML encoding using numeric character entities (e.g. &amp;#60; instead of entity references (e.g. &amp;lt;).
 * This encoder should be used instead of {@link XMLEncoder} to address some shortcomings in the KML specification and the way Google Earth (at least the desktop version) interprets HTML.
 * 
 * @see <a href="http://kml4earth.appspot.com/kmlErrata.html?#encoding">KML Reference Errata</a>
 * @see <a href="https://github.com/OWASP/owasp-java-encoder/issues/20">OWASP Issue</a>
 *
 * @author cnsgithub
 */
class KMLEncoder extends XMLEncoder {

    @Override
    protected CoderResult encodeArrays(CharBuffer input, CharBuffer output, boolean endOfInput) {
        return super.encodeArrays(input, output, endOfInput, true);
    }

}
