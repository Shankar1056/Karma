package bigappcompany.com.karma.forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import bigappcompany.com.karma.R;

/**
 * @author Samuel Robert <sam@spotsoon.com>
 * @created on 04 Nov 2017 at 2:48 PM
 */

public class PostQues extends AppCompatActivity {
	@Override
	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		setContentView(R.layout.postques);
	}
}
