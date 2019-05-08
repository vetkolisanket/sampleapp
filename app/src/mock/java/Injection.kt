import com.sanket.sampleapp.application.AppCache
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract

/**
 * Created by Sanket on 03/05/19.
 */
object Injection {
    const val PREFERENCE_FILE_NAME = "SAMPLE_APP_MOCK"

    fun getLoginPresenter(): ILoginContract.Presenter {
        return AppCache[Constants.MOCK.LOGIN_PRESENTER] as ILoginContract.Presenter
    }

}