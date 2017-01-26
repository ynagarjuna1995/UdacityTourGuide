/*
 * Copyright (C) 2016 The Android Open Source Project
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
package io.github.ynagarjuna1995.tourguide.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.ynagarjuna1995.tourguide.fragments.TemplesFragment;
import io.github.ynagarjuna1995.tourguide.fragments.MuseumsFragment;
import io.github.ynagarjuna1995.tourguide.fragments.RecreationFragment;
import io.github.ynagarjuna1995.tourguide.fragments.HistoricalFragment;


public class CategoryAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalFragment();
        } else if (position == 1) {
            return new RecreationFragment();
        } else if (position == 2) {
            return new TemplesFragment();
        } else {
            return new MuseumsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(io.github.ynagarjuna1995.tourguide.R.string.category_Monuments);
        } else if (position == 1) {
            return mContext.getString(io.github.ynagarjuna1995.tourguide.R.string.category_RecreationalPlace);
        } else if (position == 2) {
            return mContext.getString(io.github.ynagarjuna1995.tourguide.R.string.category_Temples);
        } else {
            return mContext.getString(io.github.ynagarjuna1995.tourguide.R.string.category_Museums);
        }
    }
}
