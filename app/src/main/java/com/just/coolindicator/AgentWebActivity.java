package com.just.coolindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.coolindicator.sdk.CoolIndicatorLayout;
import com.just.agentweb.AgentWeb;

public class AgentWebActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agent_web);

		CoolIndicatorLayout mCoolIndicatorLayout = new CoolIndicatorLayout(this);
		AgentWeb.with(this)
				.setAgentWebParent((ViewGroup) findViewById(R.id.framelayout), new FrameLayout.LayoutParams(-1, -1))
				.setCustomIndicator(mCoolIndicatorLayout)
				.interceptUnkownUrl()
				.setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
				.createAgentWeb()
				.ready()
				.go("https://m.vip.com/?source=www&jump_https=1");
	}
}
