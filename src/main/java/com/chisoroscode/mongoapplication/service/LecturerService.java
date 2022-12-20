package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Lecturer;

public interface LecturerService {

    Lecturer createLecturer(LecturerRequest lecturerRequest);
}
