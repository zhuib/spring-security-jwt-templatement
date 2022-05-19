package top.iaminlearn.blog.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class R implements Serializable {

    private static final long serialVersionUID = -5316597326293972581L;
    private int code;
    private String msg;
    private Map<String, Object> map = new HashMap<>();

    public R() {
    }

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static R success() {
        R r = new R();
        r.code = ReturnCodeEnum.SUCCESS.getCode();
        r.msg = ReturnCodeEnum.SUCCESS.getMsg();
        return r;
    }

    public static R success(ReturnCodeEnum ReturnCodeEnum) {
        R r = new R();
        r.code = ReturnCodeEnum.getCode();
        r.msg = ReturnCodeEnum.getMsg();
        return r;
    }

    public static R error() {
        R r = new R();
        r.code = ReturnCodeEnum.ERROR.getCode();
        r.msg = ReturnCodeEnum.ERROR.getMsg();
        return r;
    }

    public static R result(boolean b) {
        return b ? R.success() : R.error();
    }

    public static R result(boolean b, ReturnCodeEnum returnCodeEnum) {
        return b ? R.success() : R.error(returnCodeEnum);
    }


    public static R error(ReturnCodeEnum returnCodeEnum) {
        R r = new R();
        r.code = returnCodeEnum.getCode();
        r.msg = returnCodeEnum.getMsg();
        return r;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public R add(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("msg", msg)
                .append("map", map)
                .toString();
    }
}
