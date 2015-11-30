/* 
 * jBrowserDriver (TM)
 * Copyright (C) 2014-2015 Machine Publishers, LLC
 * ops@machinepublishers.com | machinepublishers.com
 * Cincinnati, Ohio, USA
 *
 * You can redistribute this program and/or modify it under the terms of the GNU Affero General Public
 * License version 3 as published by the Free Software Foundation.
 *
 * "jBrowserDriver" and "Machine Publishers" are trademarks of Machine Publishers, LLC.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License version 3 for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License version 3 along with this
 * program. If not, see http://www.gnu.org/licenses/
 * 
 * For general details about how to investigate and report license violations, please see
 * https://www.gnu.org/licenses/gpl-violation.html and email the author, ops@machinepublishers.com
 */
package com.machinepublishers.jbrowserdriver;

public class BrowserException {

  /**
   * A problem occurred, but it's likely temporary,
   * so the original operation should simply be retried.
   */
  public static class Retry extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public Retry() {
      super();
    }

    public Retry(Throwable nested) {
      super(nested);
    }

    public Retry(String message) {
      super(message);
    }
  }

  /**
   * A fatal error occurred and merely retrying the operation will likely fail.
   */
  public static class Fatal extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public Fatal() {
      super();
    }

    public Fatal(Throwable nested) {
      super(nested);
    }

    public Fatal(String message) {
      super(message);
    }

    public Fatal(String message, Throwable nested) {
      super(message, nested);
    }
  }

}
