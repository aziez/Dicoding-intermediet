package azz.aziz13.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OptionDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OptionDialogFragment  extends DialogFragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btnPilih,btnclose;
    RadioGroup rgOption;
    RadioButton rbLK,rbPR,rbAK;
    OnOptionDialogListener optionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OptionDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OptionDialogFragment newInstance(String param1, String param2) {
        OptionDialogFragment fragment = new OptionDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPilih = view.findViewById(R.id.btn_pilih);
        btnPilih.setOnClickListener(this);
        btnclose = view.findViewById(R.id.btn_close);
        btnclose.setOnClickListener(this);
        rgOption = view.findViewById(R.id.rg_options);
        rbLK = view.findViewById(R.id.rb_pria);
        rbPR = view.findViewById(R.id.rb_wanita);
        rbLK = view.findViewById(R.id.rb_anak);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        if (fragment instanceof  DetailCategory){
            DetailCategory detailCategory = (DetailCategory) fragment;
            this.optionDialogListener = detailCategory.optionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case  R.id.btn_pilih:
                int checkRadioButtonId = rgOption.getCheckedRadioButtonId();
                if (checkRadioButtonId != -1) {
                    String Fashion = null;
                    switch (checkRadioButtonId){
                        case R.id.rb_pria:
                            Fashion = rbLK.getText().toString().trim();
                            break;
                        case  R.id.rb_wanita:
                            Fashion = rbPR.getText().toString().trim();
                            break;
                        case R.id.rb_anak:
                            Fashion = rbAK.getText().toString().trim();
                            break;
                    }

                    if (optionDialogListener != null){
                        optionDialogListener.onOptionChosen(Fashion);
                    }

                    getDialog().dismiss();
                }
                break;
        }

    }

public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }

}