package com.poddlybonk.jetreddit.appdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poddlybonk.jetreddit.R
import com.poddlybonk.jetreddit.ui.theme.JetRedditThemeSettings

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    closeDrawerAction: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
    ) {
        AppDrawerHeader()
        AppDrawerBody(closeDrawerAction)
        AppDrawerFooter(modifier)
    }
}

@Composable
private fun AppDrawerHeader() {
    // TODO: Add your code here.
}

@Composable
private fun ProfileInfo() {
    // TODO: Add your code here.
}

@Composable
private fun ProfileInfoItem(
    iconAsset: ImageVector,
    amountResourceId: Int,
    textResourceId: Int,
    modifier: Modifier
) {
    // TODO: Add your code here.
}

@Composable
private fun AppDrawerBody(closeDrawerAction: () -> Unit) {
    // TODO: Add your code here.
}

@Composable
private fun ScreenNavigationButton(
    icon: ImageVector,
    label: String,
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colors

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()

    Surface(
        modifier = surfaceModifier,
        color = colors.surface,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(
            onClick = onClickAction,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon,
                    colorFilter = ColorFilter.tint(Color.Gray),
                    contentDescription = label
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    fontSize = 10.sp,
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = colors.primaryVariant
                )
            }
        }
    }
}

@Composable
private fun AppDrawerFooter(modifier: Modifier = Modifier) {
    // TODO: Add your code here
}

private fun changeTheme() {
    JetRedditThemeSettings.isInDarkTheme.value = JetRedditThemeSettings.isInDarkTheme.value.not()
}

@Preview
@Composable
private fun ProfileInfoItemPreview() {
    ProfileInfoItem(
        Icons.Filled.ShoppingCart,
        R.string.default_reddit_age_amount,
        R.string.reddit_age,
        Modifier
    )
}
