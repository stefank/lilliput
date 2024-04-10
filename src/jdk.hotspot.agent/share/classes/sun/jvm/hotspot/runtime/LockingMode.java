/*
 * Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
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
 *
 */

package sun.jvm.hotspot.runtime;

import sun.jvm.hotspot.types.TypeDataBase;


/** Encapsulates the LockingMode enum in globalDefinitions.hpp in
    the VM. */

public class LockingMode {
  private static int monitor;
  private static int legacy;
  private static int lightweight;
  private static int placeholder;

  static {
    VM.registerVMInitializedObserver(
        (o, d) -> initialize(VM.getVM().getTypeDataBase()));
  }

  private static synchronized void initialize(TypeDataBase db) {
    monitor     = db.lookupIntConstant("LM_MONITOR").intValue();
    legacy      = db.lookupIntConstant("LM_LEGACY").intValue();
    lightweight = db.lookupIntConstant("LM_LIGHTWEIGHT").intValue();
    placeholder = db.lookupIntConstant("LM_PLACEHOLDER").intValue();
  }

  public static int getMonitor() {
    return monitor;
  }

  public static int getLegacy() {
    return legacy;
  }

  public static int getLightweight() {
    return lightweight;
  }

  public static int getPlaceholder() {
    return placeholder;
  }
}
