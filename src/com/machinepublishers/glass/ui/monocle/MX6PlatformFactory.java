/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
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

package com.machinepublishers.glass.ui.monocle;

import java.io.File;

import com.machinepublishers.glass.ui.monocle.MX6Platform;
import com.machinepublishers.glass.ui.monocle.NativePlatform;
import com.machinepublishers.glass.ui.monocle.NativePlatformFactory;

class MX6PlatformFactory extends NativePlatformFactory {

    @Override
    protected boolean matches() {
        boolean retval =
            new File("/sys/devices/platform/mxc_sdc_fb.0").exists() ||
            new File("/sys/bus/platform/drivers/mxc_sdc_fb").exists();
        return retval;
    }

    @Override
    protected int getMajorVersion() {
        return 1;
    }

    @Override
    protected int getMinorVersion() {
        return 0;
    }

    @Override
    protected NativePlatform createNativePlatform() {
        return new MX6Platform();
    }

}