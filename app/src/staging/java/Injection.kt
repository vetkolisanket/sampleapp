import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract
import com.sanket.sampleapp.features.onboarding.contracts.ISignUpContract
import com.sanket.sampleapp.features.onboarding.presenters.LoginPresenter
import com.sanket.sampleapp.features.onboarding.presenters.SignUpPresenter

/**
 * Created by Sanket on 03/05/19.
 */
object Injection {

    const val PREFERENCE_FILE_NAME = "SAMPLE_APP_STAGING"

    fun getLoginPresenter(): ILoginContract.Presenter {
        return LoginPresenter()
    }

    fun getSignUpPresenter(): ISignUpContract.Presenter {
        return SignUpPresenter()
    }
}