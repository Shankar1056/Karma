package bigappcompany.com.karma.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import bigappcompany.com.karma.R;
import bigappcompany.com.karma.common.NavigationTabBar;

/**
 * @author Samuel Robert <sam@spotsoon.com>
 * @created on 23 Oct 2017 at 2:23 PM
 */

public class MainActivity extends AppCompatActivity {
	int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}
	
	private void initUI() {
		final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_horizontal_ntb);
		viewPager.setAdapter(new PagerAdapter() {
			@Override
			public int getCount() {
				return 5;
			}
			
			@Override
			public boolean isViewFromObject(final View view, final Object object) {
				return view.equals(object);
			}
			
			@Override
			public void destroyItem(final View container, final int position, final Object object) {
				((ViewPager) container).removeView((View) object);
			}
			
			@Override
			public Object instantiateItem(final ViewGroup container, final int position) {
				final View view = LayoutInflater.from(
				    getBaseContext()).inflate(R.layout.item_vp_list, null, false);
				
				final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
				recyclerView.setHasFixedSize(true);
				recyclerView.setLayoutManager(new GridLayoutManager(
				    getBaseContext(), 2)
				);
				
				recyclerView.setAdapter(new RecycleAdapter(a));
				
				container.addView(view);
				return view;
			}
		});
		
		final String[] colors = getResources().getStringArray(R.array.default_preview);
		
		final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
		final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
		models.add(
		    new NavigationTabBar.Model.Builder(
			getResources().getDrawable(R.drawable.ic_first),
			Color.parseColor(colors[0]))
			.title("Heart")
			.build()
		);
		models.add(
		    new NavigationTabBar.Model.Builder(
			getResources().getDrawable(R.drawable.ic_second),
			Color.parseColor(colors[1]))
			.title("Cup")
			.build()
		);
		models.add(
		    new NavigationTabBar.Model.Builder(
			getResources().getDrawable(R.drawable.ic_third),
			Color.parseColor(colors[2]))
			.title("Diploma")
			.build()
		);
		models.add(
		    new NavigationTabBar.Model.Builder(
			getResources().getDrawable(R.drawable.ic_fourth),
			Color.parseColor(colors[3]))
			.title("Flag")
			.build()
		);
		models.add(
		    new NavigationTabBar.Model.Builder(
			getResources().getDrawable(R.drawable.ic_fifth),
			Color.parseColor(colors[4]))
			.title("Medal")
			.build()
		);
		
		navigationTabBar.setModels(models);
		navigationTabBar.setViewPager(viewPager, 2);
		
		//IMPORTANT: ENABLE SCROLL BEHAVIOUR IN COORDINATOR LAYOUT
		navigationTabBar.setBehaviorEnabled(true);
		
		navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
			@Override
			public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {
			}
			
			@Override
			public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
				model.hideBadge();
			}
		});
		navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(final int position) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(final int state) {
				
			}
		});
		
		final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.parent);
		findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
					final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
					navigationTabBar.postDelayed(new Runnable() {
						@Override
						public void run() {
							final String title = String.valueOf(new Random().nextInt(15));
							if (!model.isBadgeShowed()) {
								model.setBadgeTitle(title);
								model.showBadge();
							} else model.updateBadgeTitle(title);
						}
					}, i * 100);
				}
				
				coordinatorLayout.postDelayed(new Runnable() {
					@Override
					public void run() {
						final Snackbar snackbar = Snackbar.make(navigationTabBar, "Coordinator NTB", Snackbar.LENGTH_SHORT);
						snackbar.getView().setBackgroundColor(Color.parseColor("#9b92b3"));
						((TextView) snackbar.getView().findViewById(R.id.snackbar_text))
						    .setTextColor(Color.parseColor("#423752"));
						snackbar.show();
					}
				}, 1000);
			}
		});
		
		final CollapsingToolbarLayout collapsingToolbarLayout =
		    (CollapsingToolbarLayout) findViewById(R.id.toolbar);
		collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#009F90AF"));
		collapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#9f90af"));
	}
	
	public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
		int[] pos;
		
		public RecycleAdapter(int[] i) {
			
			pos = i;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
			View view = null;
			/*for (int i=0;i<20;i++)
			{
				try {
					if (pos[i] % 2 == 0) {
						view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_list, parent, false);
					} else {
						view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_list_even, parent,false);
					}
				}
				catch (NumberFormatException e)
				{
					e.printStackTrace();
				}
			}*/
			view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_list, parent, false);
			
			return new ViewHolder(view);
		}
		
		@Override
		public void onBindViewHolder(final ViewHolder holder, final int position) {
			
			try {
				if ((position + 1) > 1 && (position + 1) % 2 == 0) {
					LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					lp.setMargins(0, 100, 0, 0);
					holder.layout.setLayoutParams(lp);
					holder.txt.setText(String.format("Navigation Item #%d", pos[position]));
				} else {
					holder.txt.setText(String.format("Navigation Item #%d", pos[position]));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public int getItemCount() {
			return 20;
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			
			public TextView txt;
			public LinearLayout layout;
			
			public ViewHolder(final View itemView) {
				super(itemView);
				txt = (TextView) itemView.findViewById(R.id.txt_vp_item_list);
				layout = (LinearLayout) itemView.findViewById(R.id.layout);
			}
		}
	}
}

