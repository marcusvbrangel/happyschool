package com.marcusvbrangel.happyschool.exception;


//@RestControllerAdvice
public class GlobalExceptionController {
/*

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURL().toString();

        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "Ocorreu um erro interno no servidor",
            ex.getMessage(),
            requestMethod,
            requestUrl
        );

        log.error("Erro interno no servidor, código do log: {}", errorResponse.codigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex,
                                                                HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURL().toString();

        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "O recurso solicitado não pode ser encontrado",
            ex.getMessage(),
            requestMethod,
            requestUrl

        );

        log.error("código do log: {}, mensagem: {}, método: {}, URL: {}",
            errorResponse.codigoLog(), errorResponse.friendlyErrorMessage(), requestMethod, requestUrl, ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ResourceInUseException.class)
    public ResponseEntity<ErrorResponse> handleResourceInUse(ResourceInUseException ex, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.CONFLICT;
        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURL().toString();

        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "O recurso está em uso e não pode ser modificado",
            ex.getMessage(),
            requestMethod,
            requestUrl
        );

        log.error("Recurso em uso, código do log: {}", errorResponse.codigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(ResourceAlreadyExistsException ex,
                                                                     HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURL().toString();

        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "Não pode realizar esta operação porque o recurso já existe",
            ex.getMessage(),
            requestMethod,
            requestUrl
        );

        log.error("Recurso já existe, código do log: {}", errorResponse.codigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleResourceConstraintViolation(ResourceAlreadyExistsException ex,
                                                                           HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURL().toString();

        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "Violação de restrição",
            ex.getMessage(),
            requestMethod,
            requestUrl
        );

        log.error("Violação de restrição, código do log: {}", errorResponse.codigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex,
                                                                          HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURL().toString();

        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "Erro de validação",
            ex.getMessage(),
            requestMethod,
            requestUrl
        );

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.error("Erro de validação, código do log: {}", errorResponse.codigoLog(), ex);
        return new ResponseEntity<>(errors, httpStatus);
    }
*/

}