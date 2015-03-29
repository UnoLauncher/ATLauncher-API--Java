/*
 * This file is part of ATLauncher-API---Java, licensed under the MIT License (MIT).
 *
 * Copyright (c) Jamie Mansfield <https://github.com/jamierocks>
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
package uk.jamierocks.atlauncher.test;

import uk.jamierocks.atlauncher.api.Leaderboard;
import uk.jamierocks.atlauncher.api.Response;

/**
 * Created by jamie on 28/03/15.
 */
public class LeaderboardTest {
    public static void main(String[] args) {
        Response<Leaderboard.User[]> response = Leaderboard.getPack("YogscastCompletePack", 5);
        for(Leaderboard.User user : response.getData()) {
            System.out.println(String.format("Position: %d, Username: %s, Time played: %d, Last Played: %d", user
                    .getPosition(), user.getUsername(), user.getTimePlayed(), user.getLastPlayed().getTime()));
        }
    }
}