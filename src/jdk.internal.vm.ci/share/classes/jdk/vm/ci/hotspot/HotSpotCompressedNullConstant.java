/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;

/**
 * The compressed representation of the {@link JavaConstant#NULL_POINTER null constant}.
 */
public final class HotSpotCompressedNullConstant implements JavaConstant, HotSpotConstant {

    public static final JavaConstant COMPRESSED_NULL = new HotSpotCompressedNullConstant();

    private HotSpotCompressedNullConstant() {
    }

    @Override
    public JavaKind getJavaKind() {
        return JavaKind.Object;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public boolean isCompressed() {
        return true;
    }

    @Override
    public boolean isCompressible() {
        return false;
    }

    @Override
    public Constant compress() {
        throw new IllegalArgumentException("not compressible");
    }

    @Override
    public Constant uncompress() {
        return NULL_POINTER;
    }

    @Override
    public boolean isDefaultForKind() {
        return true;
    }

    @Override
    public Object asBoxedPrimitive() {
        throw new IllegalArgumentException();
    }

    @Override
    public int asInt() {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean asBoolean() {
        throw new IllegalArgumentException();
    }

    @Override
    public long asLong() {
        throw new IllegalArgumentException();
    }

    @Override
    public float asFloat() {
        throw new IllegalArgumentException();
    }

    @Override
    public double asDouble() {
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return JavaConstant.toString(this);
    }

    @Override
    public String toValueString() {
        return "null";
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HotSpotCompressedNullConstant;
    }
}
