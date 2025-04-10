/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.picasso3;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Target<T> {

    final T target;

    final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.MonotonicNonNull Drawable errorDrawable;

    final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int errorResId;

    final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean noFade;

    @org.checkerframework.dataflow.qual.SideEffectFree
    Target(T target) {
        this.target = target;
        this.errorResId = 0;
        this.errorDrawable = null;
        this.noFade = false;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    Target(T target,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int errorResId) {
        this.target = target;
        this.errorResId = errorResId;
        this.errorDrawable = null;
        this.noFade = false;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    Target(T target, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Drawable errorDrawable) {
        this.target = target;
        this.errorResId = 0;
        this.errorDrawable = errorDrawable;
        this.noFade = false;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    Target(T target,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int errorResId, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Drawable errorDrawable,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean noFade) {
        this.target = target;
        this.errorResId = errorResId;
        this.errorDrawable = errorDrawable;
        this.noFade = noFade;
    }
}
