package detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import navigation.detail.FeatureDetailComponent

@Composable
fun FeatureDetailContent(
    component: FeatureDetailComponent,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {

        }
    }
}