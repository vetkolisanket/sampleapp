import com.sanket.sampleapp.application.AppCache
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.features.home.contracts.IHomeContract
import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract
import com.sanket.sampleapp.features.onboarding.contracts.ISignUpContract

/**
 * Created by Sanket on 03/05/19.
 */
object Injection {
    const val PREFERENCE_FILE_NAME = "SAMPLE_APP_MOCK"

    fun getLoginPresenter(): ILoginContract.Presenter {
        return AppCache[Constants.MOCK.LOGIN_PRESENTER] as ILoginContract.Presenter
    }

    fun getSignUpPresenter(): ISignUpContract.Presenter {
        return AppCache[Constants.MOCK.SIGN_UP_PRESENTER] as ISignUpContract.Presenter
    }

    fun getHomePresenter(): IHomeContract.Presenter {
        return AppCache[Constants.MOCK.HOME_PRESENTER] as IHomeContract.Presenter
    }
}