package core;

import settings.ScenarioContext;

public class BaseSteps extends ServiceInjection{

    protected final ScenarioContext scenarioContext;

    public BaseSteps() {
        super();
        this.scenarioContext = ScenarioContext.getInstance();
    }
}
