package org.ccs.app.entrypoints.common.service;

import org.ccs.app.entrypoints.common.model.PreSignedResponse;

public interface PreSignedService {

    PreSignedResponse generate(String objectKey);
}
