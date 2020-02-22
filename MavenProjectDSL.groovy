job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git(https://github.com/jitpack/maven-simple.git, 'master')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean install','pom.xml')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}