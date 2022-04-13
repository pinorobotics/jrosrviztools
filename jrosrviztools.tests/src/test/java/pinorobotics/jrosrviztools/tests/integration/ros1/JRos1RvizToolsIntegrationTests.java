/*
 * Copyright 2021 jrosrviztools project
 * 
 * Website: https://github.com/pinorobotics/jrosrviztools
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
package pinorobotics.jrosrviztools.tests.integration.ros1;

import static pinorobotics.jrosrviztools.tests.integration.ros1.TestConstants.*;

import id.jrosclient.JRos1Client;
import id.xfunction.logging.XLogger;
import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pinorobotics.jrosrviztools.JRosRvizTools;
import pinorobotics.jrosrviztools.tests.integration.JRosRvizToolsIntegrationTests;

/** @author aeon_flux aeon_flux@eclipso.ch */
public class JRos1RvizToolsIntegrationTests {

    private JRos1Client client;
    private JRosRvizTools rvizTools;

    @BeforeAll
    public static void setupAll() {
        XLogger.load("jrosrviztools-test.properties");
    }

    @BeforeEach
    public void setup() throws MalformedURLException {
        client = new JRos1Client(URL);
        rvizTools = new JRosRvizTools(client, "map", RVIZ_MARKER_TOPIC);
    }

    @AfterEach
    public void clean() throws Exception {
        rvizTools.close();
        client.close();
    }

    @Test
    public void test_all() throws Exception {
        JRosRvizToolsIntegrationTests.test_all(rvizTools);
    }
}
