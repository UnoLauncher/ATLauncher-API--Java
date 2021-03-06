/*
 * This file is part of ATLauncherAPIClientLibrary, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015-2020, Jamie Mansfield <https://www.jamierocks.uk/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package uk.jamierocks.atlauncher.api.v1.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.getLong;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import uk.jamierocks.atlauncher.api.adapter.TypeAdapter;
import uk.jamierocks.atlauncher.api.v1.model.NewsArticle;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class NewsArticleTypeAdapter implements TypeAdapter<NewsArticle> {

    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String CREATED_AT = "created_at";

    @Override
    public NewsArticle deserialize(final JsonElement json,
                                   final Type typeOfT,
                                   final JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonObject()) throw new JsonParseException("Malformed news article, must be an object!");
        final JsonObject article = json.getAsJsonObject();

        final String title = getString(article, TITLE);
        final String content = getString(article, CONTENT);
        final Instant createdAt = Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(getString(article, CREATED_AT)));

        return new NewsArticle(title, content, createdAt);
    }

    @Override
    public JsonElement serialize(final NewsArticle src,
                                 final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        final JsonObject object = new JsonObject();
        object.addProperty(TITLE, src.getTitle());
        object.addProperty(CONTENT, src.getContent());
        object.addProperty(CREATED_AT, DateTimeFormatter.ISO_DATE_TIME.format(src.getCreatedAt()));
        return object;
    }

}
