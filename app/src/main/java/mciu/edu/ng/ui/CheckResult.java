package mciu.edu.ng.ui;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import mciu.edu.ng.R;
import mciu.edu.ng.databinding.FragmentCheckResultBinding;
import mciu.edu.ng.databinding.FragmentContactUsBinding;
import mciu.edu.ng.ui.slideshow.SlideshowViewModel;

public class CheckResult extends Fragment {

    private FragmentCheckResultBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCheckResultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        AdView adView = binding.adView;
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);



        WebView webView = (WebView)root.findViewById(R.id.Webviewcheckresult);
        ProgressBar progressBar = root.findViewById(R.id.progressbarnews);




        webView.loadUrl("https://mciu.jboyholdings.org/result-search/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClient webViewClient = new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);

            }
        };


        webView.setWebViewClient(webViewClient);
        webSettings.setBuiltInZoomControls(true);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}