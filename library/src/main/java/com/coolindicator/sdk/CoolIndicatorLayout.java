
/*
 * MIT License
 *
 * Copyright (c) 2018 Justson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.coolindicator.sdk;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.just.agentweb.AgentWebUtils;
import com.just.agentweb.BaseIndicatorView;



public class CoolIndicatorLayout extends BaseIndicatorView {
	public CoolIndicatorLayout(Context context) {
		this(context, null);
	}

	private static final String TAG = CoolIndicatorLayout.class.getSimpleName();
	CoolIndicator mCoolIndicator = null;

	public CoolIndicatorLayout(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, -1);
	}

	public CoolIndicatorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mCoolIndicator = new CoolIndicator(context, null, android.R.style.Widget_Material_ProgressBar_Horizontal);
		mCoolIndicator.setMax(100);
		this.addView(mCoolIndicator, offerLayoutParams());
//		mAnimatedProgressBar.setScrollBarFadeDuration(500);

	}

	@Override
	public void show() {
		this.setVisibility(View.VISIBLE);
		mCoolIndicator.start();
	}

	@Override
	public void setProgress(int newProgress) {
		Log.i(TAG, "newProgress:" + newProgress);
	}

	@Override
	public void hide() {
		mCoolIndicator.complete();
	}

	@Override
	public LayoutParams offerLayoutParams() {
		return new FrameLayout.LayoutParams(-1, AgentWebUtils.dp2px(getContext(), 3));
	}
}
