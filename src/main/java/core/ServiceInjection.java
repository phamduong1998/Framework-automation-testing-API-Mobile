package core;

import com.google.inject.Inject;
import core.api.service.LoginTodiistService;

abstract class ServiceInjection {

    @Inject
    protected LoginTodiistService loginTodiistService;
}
