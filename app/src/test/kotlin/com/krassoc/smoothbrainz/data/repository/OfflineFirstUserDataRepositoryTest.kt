package com.krassoc.smoothbrainz.data.repository

//import com.krassoc.smoothbrainz.data.services.local.SharedPreferencesService
import com.krassoc.smoothbrainz.model.services.ISharedPreferencesService
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before

class OfflineFirstUserDataRepositoryTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: UserDataRepositoryImpl

    private lateinit var preferencesDataSource: ISharedPreferencesService

    @Before
    fun setup() {
        //preferencesDataSource = ISharedPreferencesService(InMemoryDataStore(UserPreferences.getDefaultInstance()))
        //subject = OfflineFirstUserDataRepositoryImpl( preferencesDataSource = preferencesDataSource,)
    }
/*
    @Test
    fun offlineFirstUserDataRepository_default_user_data_is_correct() =
        testScope.runTest {
            assertEquals(
                UserData(
                    themeBrand = ThemeBrand.DEFAULT,
                    darkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM,
                    useDynamicColor = false,
                    shouldHideOnboarding = false,
                ),
                subject.userData.first(),
            )
        }

    @Test
    fun offlineFirstUserDataRepository_set_theme_brand_delegates_to_nia_preferences() =
        testScope.runTest {
            subject.setThemeBrand(ThemeBrand.ANDROID)

            assertEquals(
                ThemeBrand.ANDROID,
                subject.userData
                    .map { it.themeBrand }
                    .first(),
            )
            assertEquals(
                ThemeBrand.ANDROID,
                preferencesDataSource
                    .userData
                    .map { it.themeBrand }
                    .first(),
            )
        }

    @Test
    fun offlineFirstUserDataRepository_set_dynamic_color_delegates_to_nia_preferences() =
        testScope.runTest {
            subject.setDynamicColorPreference(true)

            assertEquals(
                true,
                subject.userData
                    .map { it.useDynamicColor }
                    .first(),
            )
            assertEquals(
                true,
                preferencesDataSource
                    .userData
                    .map { it.useDynamicColor }
                    .first(),
            )
        }

    @Test
    fun offlineFirstUserDataRepository_set_dark_theme_config_delegates_to_nia_preferences() =
        testScope.runTest {
            subject.setDarkThemeConfig(DarkThemeConfig.DARK)

            assertEquals(
                DarkThemeConfig.DARK,
                subject.userData
                    .map { it.darkThemeConfig }
                    .first(),
            )
            assertEquals(
                DarkThemeConfig.DARK,
                preferencesDataSource
                    .userData
                    .map { it.darkThemeConfig }
                    .first(),
            )
        }
 */
}
