package model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *
 *说明：返回数据封装
 *@since: 2020-09-16
 *@author: shijie
 *
 */
@Keep
@Entity(tableName = "tab_github_call_record")
data class GitHubData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("current_user_url")
    var currentUserUrl: String? = null,

    @SerializedName("current_user_authorizations_html_url")
    var currentUserAuthorizationsHtmlUrl: String? = null,

    @SerializedName("authorizations_url")
    var authorizationsUrl: String? = null,

    @SerializedName("code_search_url")
    var codeSearchUrl: String? = null,

    @SerializedName("commit_search_url")
    var commitSearchUrl: String? = null,

    @SerializedName("emails_url")
    var emailsUrl: String? = null,

    @SerializedName("emojis_url")
    var emojisUrl: String? = null,

    @SerializedName("events_url")
    var eventsUrl: String? = null,

    @SerializedName("feeds_url")
    var feedsUrl: String? = null,

    @SerializedName("followers_url")
    var followersUrl: String? = null,

    @SerializedName("following_url")
    var followingUrl: String? = null,

    @SerializedName("gists_url")
    var gistsUrl: String? = null,

    @SerializedName("hub_url")
    var hubUrl: String? = null,

    @SerializedName("issue_search_url")
    var issueSearchUrl: String? = null,

    @SerializedName("issues_url")
    var issuesUrl: String? = null,

    @SerializedName("keys_url")
    var keysUrl: String? = null,

    @SerializedName("label_search_url")
    var labelSearchUrl: String? = null,

    @SerializedName("notifications_url")
    var notificationsUrl: String? = null,

    @SerializedName("organization_url")
    var organizationUrl: String? = null,

    @SerializedName("organization_repositories_url")
    var organizationRepositoriesUrl: String? = null,

    @SerializedName("organization_teams_url")
    var organizationTeamsUrl: String? = null,

    @SerializedName("public_gists_url")
    var publicGistsUrl: String? = null,

    @SerializedName("rate_limit_url")
    var rateLimitUrl: String? = null,

    @SerializedName("repository_url")
    var repositoryUrl: String? = null,

    @SerializedName("repository_search_url")
    var repositorySearchUrl: String? = null,

    @SerializedName("current_user_repositories_url")
    var currentUserRepositoriesUrl: String? = null,

    @SerializedName("starred_url")
    var starredUrl: String? = null,

    @SerializedName("starred_gists_url")
    var starredGistsUrl: String? = null,

    @SerializedName("user_url")
    var userUrl: String? = null,

    @SerializedName("user_organizations_url")
    var userOrganizationsUrl: String? = null,

    @SerializedName("user_repositories_url")
    var userRepositoriesUrl: String? = null,

    @SerializedName("user_search_url")
    var userSearchUrl: String? = null
)