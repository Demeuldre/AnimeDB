<p align="center">
  <img src="https://img.icons8.com/?size=512&id=55494&format=png" width="20%" alt="ANIMEDB-logo">
</p>
<p align="center">
    <h1 align="center">ANIMEDB</h1>
</p>
<p align="center">
    <em><code>❯ REPLACE-ME</code></em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/Demeuldre/AnimeDB?style=flat&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/Demeuldre/AnimeDB?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Demeuldre/AnimeDB?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Demeuldre/AnimeDB?style=flat&color=0080ff" alt="repo-language-count">
</p>
<p align="center">
		<em>Built with the tools and technologies:</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/Android-3DDC84.svg?style=flat&logo=Android&logoColor=white" alt="Android">
	<img src="https://img.shields.io/badge/Gradle-02303A.svg?style=flat&logo=Gradle&logoColor=white" alt="Gradle">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
</p>

<br>

#####  Table of Contents

- [ Overview](#-overview)
- [ Features](#-features)
- [ Repository Structure](#-repository-structure)
- [ Getting Started](#-getting-started)
    - [ Prerequisites](#-prerequisites)
    - [ Installation](#-installation)
    - [ Usage](#-usage)
    - [ Tests](#-tests)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)

---

##  Overview

<p>This project is an Android application that provides a streamlined anime database for users to browse, view, and manage their favorite anime shows. The app connects to a remote server to retrieve detailed information about various anime series, including their titles, genres, episodes, and more. Users can explore the database, view anime images and summaries, and mark their favorite shows for easy access. The app is designed with an intuitive interface, ensuring that users can quickly find the content they are interested in.
</p>

---

##  Features
<ul>
	<li><b>Anime List Display:</b>Browse through a list of anime series with detailed information such as title, genres, episodes, status, and rating.</li>
	<li><b>Anime Details View:</b>Each anime entry includes a high-quality image, synopsis, and additional details like the number of episodes and the anime’s current status (ongoing or completed).</li>
	<li><b>Favorites Management:</b> Users can mark anime as favorites for quicker access, with favorite status saved within the app.</li>
	<li><b>Seamless Image Loading:</b> Anime images are loaded dynamically from a remote source using the Picasso library, with a fallback placeholder for missing images.</li>
	<li><b>Responsive UI:</b> The app is optimized to provide a smooth user experience with a custom list view and dynamic content loading through a progress bar.</li>
	<li><b>Real-time Data Retrieval:</b> The app fetches anime data from a remote server, ensuring that the information is up-to-date, and handles JSON responses efficiently.</li>
</ul>
 
 

---

##  Repository Structure

```sh
└── AnimeDB/
    ├── README.md
    ├── app
    │   ├── .gitignore
    │   ├── build.gradle
    │   ├── proguard-rules.pro
    │   └── src
    ├── build.gradle
    ├── gradle
    │   └── wrapper
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle
```

---

##  Getting Started

###  Prerequisites

**Java**: `version x.y.z`

###  Installation

Build the project from source:

1. Clone the AnimeDB repository:
```sh
❯ git clone https://github.com/Demeuldre/AnimeDB
```

2. Navigate to the project directory:
```sh
❯ cd AnimeDB
```

3. Install the required dependencies:
```sh
❯ mvn clean install
```

###  Usage

To run the project, execute the following command:

```sh
❯ java -jar target/myapp.jar
```

###  Tests

Execute the test suite using the following command:

```sh
❯ mvn test
```

---

##  Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/Demeuldre/AnimeDB/issues)**: Submit bugs found or log feature requests for the `AnimeDB` project.
- **[Submit Pull Requests](https://github.com/Demeuldre/AnimeDB/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/Demeuldre/AnimeDB/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/Demeuldre/AnimeDB
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/Demeuldre/AnimeDB/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=Demeuldre/AnimeDB">
   </a>
</p>
</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---
