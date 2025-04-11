/*
 * Copyright 2018 Roberto Leinardi.
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

package com.leinardi.android.speeddial.sample;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialOverlayLayout;
import com.leinardi.android.speeddial.SpeedDialView;

/**
 * Main activity of the sample project
 */
@SuppressWarnings("PMD") // sample project with long methods
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int DATASET_COUNT = 60;
    private static final int ADD_ACTION_POSITION = 4;
    private String[] mDataset;
    private SpeedDialView mSpeedDialView;
    private Toast mToast;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initDataset();
        initRecyclerView();
        initSpeedDial(savedInstanceState == null);
    }

    private void initSpeedDial(boolean addActionItems) {
        mSpeedDialView = findViewById(R.id.speedDial);

        if (addActionItems) {
            mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_no_label, R.drawable
                    .ic_link_white_24dp)
                    .create());

            mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_long_label, R.drawable
                    .ic_lorem_ipsum)
                    .setLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                            "incididunt ut labore et dolore magna aliqua.")
                    .create());

            Drawable drawable = AppCompatResources.getDrawable(MainActivity.this, R.drawable.ic_custom_color);
            mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_custom_color, drawable)
                    .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.material_white_1000,
                            getTheme()))
                    .setFabImageTintColor(ResourcesCompat.getColor(getResources(), R.color.inbox_primary, getTheme()))
                    .setLabel(getString(R.string.label_custom_color))
                    .setLabelColor(Color.WHITE)
                    .setLabelBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.inbox_primary,
                            getTheme()))
                    .create());

            drawable = AppCompatResources.getDrawable(MainActivity.this, R.drawable.ic_add_white_24dp);
            mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_add_action, drawable)
                    .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.material_green_500,
                            getTheme()))
                    .setLabel(getString(R.string.label_add_action))
                    .create());

            mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_custom_theme, R.drawable
                    .ic_theme_white_24dp)
                    .setLabel(getString(R.string.label_custom_theme))
                    .setTheme(R.style.AppTheme_Purple)
                    .create());

        }

        SpeedDialOverlayLayout speedDialOverlayLayout = findViewById(R.id.overlay);
        mSpeedDialView.setOverlayLayout(speedDialOverlayLayout);

        //Set main action clicklistener.
        mSpeedDialView.setOnChangeListener(new SpeedDialView.OnChangeListener() {
            @Override
            public void onMainActionSelected() {
                showToast("Main action clicked!");
                if (mSpeedDialView.isOpen()) {
                    mSpeedDialView.close();
                }
            }

            @Override
            public void onToggleChanged(boolean isOpen) {
                Log.d(TAG, "Speed dial toggle state changed. Open = " + isOpen);
            }
        });

        //Set option fabs clicklisteners.
        mSpeedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {
                switch (actionItem.getId()) {
                    case R.id.fab_no_label:
                        showToast("No label action clicked!");
                        break;
                    case R.id.fab_long_label:
                        showSnackbar(actionItem.getLabel() + " clicked!");
                        return true;
                    case R.id.fab_custom_color:
                        showToast(actionItem.getLabel() + " clicked!");
                        break;
                    case R.id.fab_custom_theme:
                        showToast(actionItem.getLabel() + " clicked!");
                        break;
                    case R.id.fab_add_action:
                        mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_replace_action,
                                R.drawable.ic_replace_white_24dp)
                                .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color
                                                .material_orange_500,
                                        getTheme()))
                                .setLabel(getString(R.string.label_replace_action))
                                .create(), ADD_ACTION_POSITION);
                        return true;
                    case R.id.fab_replace_action:
                        mSpeedDialView.replaceActionItem(new SpeedDialActionItem.Builder(R.id
                                .fab_remove_action,
                                R.drawable.ic_delete_white_24dp)
                                .setLabel(getString(R.string.label_remove_action))
                                .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.inbox_accent,
                                        getTheme()))
                                .create(), ADD_ACTION_POSITION);
                        return true;
                    case R.id.fab_remove_action:
                        mSpeedDialView.removeActionItemById(R.id.fab_remove_action);
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        //Closes menu if its opened.
        if (mSpeedDialView.isOpen()) {
            mSpeedDialView.close();
        } else {
            super.onBackPressed();
        }

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter adapter = new CustomAdapter(mDataset);
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void showToast(String text) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        mToast.show();
    }

    private void showSnackbar(String text) {
        mSnackbar = Snackbar.make(mSpeedDialView, text, Snackbar.LENGTH_SHORT);
        mSnackbar.setAction("Close", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar.dismiss();
            }
        });
        mSnackbar.show();
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
