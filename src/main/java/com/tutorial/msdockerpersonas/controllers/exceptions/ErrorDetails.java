package com.tutorial.msdockerpersonas.controllers.exceptions;

import java.util.Date;

public record ErrorDetails(Date timestamp, String message, String details) {
}
