/* 
 * jBrowserDriver (TM)
 * Copyright (C) 2014-2016 Machine Publishers, LLC
 * 
 * Sales and support: ops@machinepublishers.com
 * Updates: https://github.com/MachinePublishers/jBrowserDriver
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
package com.machinepublishers.jbrowserdriver;

import java.util.concurrent.TimeUnit;

class Timeouts implements org.openqa.selenium.WebDriver.Timeouts {
  private final TimeoutsRemote remote;
  private final SocketLock lock;

  Timeouts(TimeoutsRemote remote, SocketLock lock) {
    this.remote = remote;
    this.lock = lock;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Timeouts implicitlyWait(long duration, TimeUnit unit) {
    try {
      synchronized (lock) {
        TimeoutsRemote timeouts = remote.implicitlyWait(duration, unit);
        if (timeouts == null) {
          return null;
        }
        return new Timeouts(timeouts, lock);
      }
    } catch (Throwable t) {
      Util.handleException(t);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Timeouts pageLoadTimeout(long duration, TimeUnit unit) {
    try {
      synchronized (lock) {
        TimeoutsRemote timeouts = remote.pageLoadTimeout(duration, unit);
        if (timeouts == null) {
          return null;
        }
        return new Timeouts(timeouts, lock);
      }
    } catch (Throwable t) {
      Util.handleException(t);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Timeouts setScriptTimeout(long duration, TimeUnit unit) {
    try {
      synchronized (lock) {
        TimeoutsRemote timeouts = remote.setScriptTimeout(duration, unit);
        if (timeouts == null) {
          return null;
        }
        return new Timeouts(timeouts, lock);
      }
    } catch (Throwable t) {
      Util.handleException(t);
      return null;
    }
  }

  long getImplicitlyWaitMS() {
    try {
      synchronized (lock) {
        return remote.getImplicitlyWaitMS();
      }
    } catch (Throwable t) {
      Util.handleException(t);
      return -1;
    }
  }

  long getPageLoadTimeoutMS() {
    try {
      synchronized (lock) {
        return remote.getPageLoadTimeoutMS();
      }
    } catch (Throwable t) {
      Util.handleException(t);
      return -1;
    }
  }

  long getScriptTimeoutMS() {
    try {
      synchronized (lock) {
        return remote.getScriptTimeoutMS();
      }
    } catch (Throwable t) {
      Util.handleException(t);
      return -1;
    }
  }
}
