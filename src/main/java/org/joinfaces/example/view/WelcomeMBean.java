/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces.example.view;

import jakarta.faces.context.FacesContext;
import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import java.util.Arrays;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * WelcomeMBean.
 *
 * @author Marcelo Fernandes
 */
@Component
@ViewScoped
@Setter
@Slf4j
public class WelcomeMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text = "";
        
        public List<String> getDataList() {
            log.info("getDataList called: " + jsfPhase());
            return Arrays.asList("HI", "HELLO");
        }

        public String getText() {
            log.info("getText called: " + jsfPhase());
            return text;
        }
 
        public void find() {
            log.info("find called: " + jsfPhase());            
        }
        
        public List<String> getDetails(String item) {
            log.info("getDetails called with '" + item + "' : " + jsfPhase());
            return Arrays.asList("detail1", "detail2");
        }
        
        private String jsfPhase() {
            return FacesContext.getCurrentInstance().getCurrentPhaseId().getName();
        }
}
