
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
package com.just.coolindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.just.agentweb.AgentWeb;


/**
 * @author cenxiaozhong
 * @date 2018/2/23
 * @since 1.0.0
 */
public class AgentWebActivity extends AppCompatActivity {

	private AgentWeb mAgentWeb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agent_web);

		CoolIndicatorLayout mCoolIndicatorLayout = new CoolIndicatorLayout(this);
		mAgentWeb = AgentWeb.with(this)
				.setAgentWebParent((ViewGroup) findViewById(R.id.framelayout), new FrameLayout.LayoutParams(-1, -1))
				.setCustomIndicator(mCoolIndicatorLayout)
				.interceptUnkownUrl()
				.setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
				.createAgentWeb()
				.ready()
				.go("https://m.vip.com/?source=www&jump_https=1");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mAgentWeb.getWebLifeCycle().onDestroy();
	}
}
