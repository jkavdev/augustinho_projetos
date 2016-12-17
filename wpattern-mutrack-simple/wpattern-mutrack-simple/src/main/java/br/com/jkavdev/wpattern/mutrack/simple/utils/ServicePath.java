package br.com.jkavdev.wpattern.mutrack.simple.utils;

//Classe de Definição de caminhos de URLs

public final class ServicePath {

	public static final String ALL = "/**";
	public static final String ROOT_PATH = "/api";
	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";
	public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";

	public static final String USER_PATH = PRIVATE_ROOT_PATH + "/user";
	public static final String PACKAGEE_PATH = PRIVATE_ROOT_PATH + "/packagee";
	public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";
	public static final String USERPERMISSION_PATH = PRIVATE_ROOT_PATH + "/userpermission";

}
