/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id: AddNumbersImpl3.java 52501 2007-01-24 02:29:49Z af70133 $
 */

package com.sun.ts.tests.jaxws.wsa.w2j.document.literal.anonymous;

import com.sun.ts.lib.util.*;
import com.sun.ts.lib.porting.*;
import com.sun.ts.lib.harness.*;

import jakarta.jws.WebService;
import jakarta.xml.ws.soap.Addressing;

@WebService(portName = "AddNumbersPort3", serviceName = "AddNumbersService", targetNamespace = "http://example.com/", wsdlLocation = "WEB-INF/wsdl/WSAW2JDLAnonymousTest.wsdl", endpointInterface = "com.sun.ts.tests.jaxws.wsa.w2j.document.literal.anonymous.AddNumbersPortType3")

public class AddNumbersImpl3 implements AddNumbersPortType3 {

  public int addNumbers(int number1, int number2, String testName)
      throws AddNumbersFault_Exception {
    if (number1 < 0 || number2 < 0) {
      AddNumbersFault faultInfo = createAddNumbersFault(number1, number2);
      throw new AddNumbersFault_Exception(faultInfo.getMessage(), faultInfo);
    }

    return number1 + number2;
  }

  AddNumbersFault createAddNumbersFault(int number1, int number2) {
    ObjectFactory of = new ObjectFactory();
    AddNumbersFault faultInfo = of.createAddNumbersFault();
    faultInfo.setDetail("Negative numbers cant be added!");
    faultInfo.setMessage("Numbers: " + number1 + ", " + number2);

    return faultInfo;
  }
}
