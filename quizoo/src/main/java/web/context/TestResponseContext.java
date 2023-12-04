package web.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;

public class TestResponseContext implements ResponseContext {
