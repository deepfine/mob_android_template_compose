/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}