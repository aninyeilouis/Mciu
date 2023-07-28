package mciu.edu.ng.ui;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import mciu.edu.ng.R;
import mciu.edu.ng.databinding.FragmentStaffLoginBinding;
import mciu.edu.ng.databinding.FragmentStudentPortalBinding;

public class StudentPortal extends Fragment {

    private FragmentStudentPortalBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentStudentPortalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        WebView webView = (WebView)root.findViewById(R.id.Webviewstudent);
        ProgressBar progressBar = root.findViewById(R.id.progressbar);

        AdView adView = binding.adView;
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);




        webView.loadUrl("https://mciu.jboyholdings.org/login");
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
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (( i == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                // If it wasn't the Back key or there's no web page history, bubble up to the default
                // system behavior (probably exit the activity)
                return StudentPortal.super.isResumed();

            }
        });

        return root;



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
