import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract
import com.sanket.sampleapp.features.onboarding.presenters.LoginPresenter

/**
 * Created by Sanket on 03/05/19.
 */
object Injection {
    fun getLoginPresenter(): ILoginContract.Presenter {
        return LoginPresenter()
    }

    const val PREFERENCE_FILE_NAME = "SAMPLE_APP_STAGING"


}