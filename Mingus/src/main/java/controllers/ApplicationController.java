/**
 * Copyright (C) 2013 the original author or authors.
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

package controllers;

import com.google.inject.Inject;
import dao.dbDao;
import models.Contacts;
import models.History;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.Param;

import java.util.List;


@Singleton
public class ApplicationController {

    @Inject
    private dbDao dbdao;


    public Result index() {
        List<Contacts> contacts = dbdao.getContacts();
        return Results.html().render("contacts",contacts);

    }

    public Result actions() {
        List<History> history = dbdao.getHistory();
        return Results.json().render(history);
    }


    public Result newAction(@Param("fk") Long fk) {
        dbdao.setNewAction(fk);
        return Results.redirect("/index");
    }

}
