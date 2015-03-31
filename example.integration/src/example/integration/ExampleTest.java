package example.integration;

import java.io.File;

import junit.framework.TestCase;

import aQute.bnd.build.Project;
import aQute.bnd.build.ProjectLauncher;
import aQute.bnd.build.Workspace;

public class ExampleTest extends TestCase {

    public final void testTest() throws Exception
    {
        Workspace workspace = Workspace.getWorkspace(new File("").getAbsoluteFile().getParentFile());
        workspace.clear();
        Project project = workspace.getProject("example.project");
        project.setTrace(true);
        project.clear();
        project.forceRefresh();
        assertTrue(project.check());
        
        ProjectLauncher launch = project.getProjectLauncher();
        launch.setTrace(true);
        launch.launch();
    }
}
