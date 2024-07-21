package navigation.feature

class FakeFeatureComponent: FeatureComponent {

    override fun onBackPressed() = Unit

    override fun onDetailClicked(id: String) = Unit

}