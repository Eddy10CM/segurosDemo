package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 23/08/16.
 */
public class CambiarContasenaFragment extends Fragment {

    CheckBox check, show_password;
    EditText password, password_confirm;
    TextInputLayout layout;
    Button actualizar;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cambiar_contrasena,container,false);

        check = (CheckBox) view.findViewById(R.id.check);
        show_password = (CheckBox) view.findViewById(R.id.show_password);

        password = (EditText) view.findViewById(R.id.edit_contrasena);
        password_confirm = (EditText) view.findViewById(R.id.confirmar_contrasena);

        layout = (TextInputLayout) view.findViewById(R.id.edit_contrasena_);

        actualizar = (Button) view.findViewById(R.id.actualizar);

        password.setEnabled(false);
        password_confirm.setEnabled(false);
        show_password.setEnabled(false);
        actualizar.setBackground(getResources().getDrawable(R.drawable.background_button_pop_disable));

        actualizar.setEnabled(false);

        check.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if (check.isChecked()){

                    actualizar.setBackground(getResources().getDrawable(R.drawable.background_button_pop));

                    password.setFocusableInTouchMode(true);
                    password.setFocusable(true);

                    password_confirm.setFocusableInTouchMode(true);
                    password_confirm.setFocusable(true);

                    password.setEnabled(true);
                    password_confirm.setEnabled(true);

                    show_password.setEnabled(true);

                    actualizar.setEnabled(true);
                    show_password.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (show_password.isChecked()){
                                password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                password_confirm.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            }else {
                                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                password_confirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            }
                        }
                    });
                }

                else {
                    actualizar.setBackground(getResources().getDrawable(R.drawable.background_button_pop_disable));
                    password.setFocusableInTouchMode(false);
                    password.setFocusable(false);

                    password_confirm.setFocusableInTouchMode(false);
                    password_confirm.setFocusable(false);

                    password.setText("");
                    password_confirm.setText("");

                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(password.getWindowToken(), 0);

                    show_password.setChecked(false);

                    password.setEnabled(false);
                    password_confirm.setEnabled(false);

                    show_password.setEnabled(false);

                    actualizar.setEnabled(false);
                }
            }
        });



        return view;
    }

}
