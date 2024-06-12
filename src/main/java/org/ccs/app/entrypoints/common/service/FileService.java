package org.ccs.app.entrypoints.common.service;

import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedGenerateRequest;
import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedResponse;

public interface FileService {

    PreSignedResponse generatePreSignedUrl(PreSignedGenerateRequest request);
}
