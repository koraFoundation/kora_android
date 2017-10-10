package com.kora.android.presentation.ui.registration.currencies;

import com.kora.android.presentation.model.Country;
import com.kora.android.presentation.ui.base.view.BaseView;

import java.util.List;

public interface CurrenciesView extends BaseView<CurrenciesPresenter> {

    void showCurrencies(final List<Country> countryList);
}
