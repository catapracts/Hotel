//  uniformjs.com v2.0.0
(function(e, t) {
    "use strict";
    function n(e) {
        var t = Array.prototype.slice.call(arguments, 1);
        return e.prop ? e.prop.apply(e, t) : e.attr.apply(e, t)
    }
    function s(e, t, n) {
        var s, a;
        for (s in n)
            n.hasOwnProperty(s) && (a = s.replace(/ |$/g, t.eventNamespace),
            e.bind(s, n[s]))
    }
    function a(e, t, n) {
        s(e, n, {
            focus: function() {
                t.addClass(n.focusClass)
            },
            blur: function() {
                t.removeClass(n.focusClass),
                t.removeClass(n.activeClass)
            },
            mouseenter: function() {
                t.addClass(n.hoverClass)
            },
            mouseleave: function() {
                t.removeClass(n.hoverClass),
                t.removeClass(n.activeClass)
            },
            "mousedown touchbegin": function() {
                e.is(":disabled") || t.addClass(n.activeClass)
            },
            "mouseup touchend": function() {
                t.removeClass(n.activeClass)
            }
        })
    }
    function i(e, t) {
        e.removeClass(t.hoverClass + " " + t.Class + " " + t.activeClass)
    }
    function r(e, t, n) {
        n ? e.addClass(t) : e.removeClass(t)
    }
    function o(e, t, n) {
        var s = "checked"
          , a = t.is(":" + s);
        t.prop ? t.prop(s, a) : a ? t.attr(s, s) : t.removeAttr(s),
        r(e, n.checkedClass, a)
    }
    function l(e, t, n) {
        r(e, n.disabledClass, t.is(":disabled"))
    }
    function u(e, t, n) {
        switch (n) {
        case "after":
            return e.after(t),
            e.next();
        case "before":
            return e.before(t),
            e.prev();
        case "wrap":
            return e.wrap(t),
            e.parent()
        }
        return null
    }
    function c(t, s, a) {
        var i, r, o;
        return a || (a = {}),
        a = e.extend({
            bind: {},
            divClass: null,
            divWrap: "wrap",
            spanClass: null,
            spanHtml: null,
            spanWrap: "wrap"
        }, a),
        i = e("<div />"),
        r = e("<span />"),
        s.autoHide && t.is(":hidden") && "none" === t.css("display") && i.hide(),
        a.divClass && i.addClass(a.divClass),
        a.spanClass && r.addClass(a.spanClass),
        o = n(t, "id"),
        s.useID && o && n(i, "id", s.idPrefix + "-" + o),
        a.spanHtml && r.html(a.spanHtml),
        i = u(t, i, a.divWrap),
        r = u(t, r, a.spanWrap),
        l(i, t, s),
        {
            div: i,
            span: r
        }
    }
    function f() {
        var t, n, s, a;
        return a = "rgb(120,2,153)",
        n = e('<div style="width:0;height:0;color:' + a + '">'),
        e("body").append(n),
        s = n.get(0),
        t = window.getComputedStyle ? window.getComputedStyle(s, "").color : (s.currentStyle || s.style || {}).color,
        n.remove(),
        t.replace(/ /g, "") !== a
    }
    function d(t) {
        return t ? e("<span />").text(t).html() : ""
    }
    function m(e) {
        var t;
        return e[0].multiple ? !0 : (t = n(e, "size"),
        !t || 1 >= t ? !1 : !0)
    }
    function p() {
        return !1
    }
    function v(e, t) {
        var n = "none";
        s(e, t, {
            "selectstart dragstart mousedown": p
        }),
        e.css({
            MozUserSelect: n,
            msUserSelect: n,
            webkitUserSelect: n,
            userSelect: n
        })
    }
    function h(e, t, n) {
        var s = e.val();
        "" === s ? s = n.fileDefaultHtml : (s = s.split(/[\/\\]+/),
        s = s[s.length - 1]),
        t.text(s)
    }
    function C(e, t, n) {
        var s, a;
        for (s = [],
        e.each(function() {
            var e;
            for (e in t)
                Object.prototype.hasOwnProperty.call(t, e) && (s.push({
                    el: this,
                    name: e,
                    old: this.style[e]
                }),
                this.style[e] = t[e])
        }),
        n(); s.length; )
            a = s.pop(),
            a.el.style[a.name] = a.old
    }
    function b(e, t) {
        C(e.parents().andSelf().not(":visible"), {
            visibility: "hidden",
            display: "block",
            position: "absolute"
        }, t)
    }
    function w(e, t) {
        return function() {
            e.unwrap().unwrap().unbind(t.eventNamespace)
        }
    }
    var y = !0
      , g = !1
      , k = [{
        match: function(e) {
            return e.is("a, button, :submit, :reset, input[type='button']")
        },
        apply: function(e, t) {
            var r, o, u, f, m;
            return o = t.submitDefaultHtml,
            e.is(":reset") && (o = t.resetDefaultHtml),
            f = e.is("a, button") ? function() {
                return e.html() || o
            }
            : function() {
                return d(n(e, "value")) || o
            }
            ,
            u = c(e, t, {
                divClass: t.buttonClass,
                spanHtml: f()
            }),
            r = u.div,
            a(e, r, t),
            m = !1,
            s(r, t, {
                "click touchend": function() {
                    var t, s, a, i;
                    m || (m = !0,
                    e[0].dispatchEvent ? (t = document.createEvent("MouseEvents"),
                    t.initEvent("click", !0, !0),
                    s = e[0].dispatchEvent(t),
                    (jQuery.browser.msie || jQuery.browser.mozilla) && e.is("a") && s && (a = n(e, "target"),
                    i = n(e, "href"),
                    a && "_self" !== a ? window.open(i, a) : document.location.href = i)) : e.click(),
                    m = !1)
                }
            }),
            v(r, t),
            {
                remove: function() {
                    return r.after(e),
                    r.remove(),
                    e.unbind(t.eventNamespace),
                    e
                },
                update: function() {
                    i(r, t),
                    l(r, e, t),
                    u.span.html(f())
                }
            }
        }
    }, {
        match: function(e) {
            return e.is(":checkbox")
        },
        apply: function(e, t) {
            var n, r, u;
            return n = c(e, t, {
                divClass: t.checkboxClass
            }),
            r = n.div,
            u = n.span,
            a(e, r, t),
            s(e, t, {
                "click touchend": function() {
                    o(u, e, t)
                }
            }),
            o(u, e, t),
            {
                remove: w(e, t),
                update: function() {
                    i(r, t),
                    u.removeClass(t.checkedClass),
                    o(u, e, t),
                    l(r, e, t)
                }
            }
        }
    }, {
        match: function(e) {
            return e.is(":file")
        },
        apply: function(t, r) {
            function o() {
                h(t, m, r)
            }
            var f, d, m, p;
            return f = c(t, r, {
                divClass: r.fileClass,
                spanClass: r.fileButtonClass,
                spanHtml: r.fileButtonHtml,
                spanWrap: "after"
            }),
            d = f.div,
            p = f.span,
            m = e("<span />").html(r.fileDefaultHtml),
            m.addClass(r.filenameClass),
            m = u(t, m, "after"),
            n(t, "size") || n(t, "size", d.width() / 10),
            a(t, d, r),
            o(),
            e.browser.msie ? s(t, r, {
                click: function() {
                    t.trigger("change"),
                    setTimeout(o, 0)
                }
            }) : s(t, r, {
                change: o
            }),
            v(m, r),
            v(p, r),
            {
                remove: function() {
                    return m.remove(),
                    p.remove(),
                    t.unwrap().unbind(r.eventNamespace)
                },
                update: function() {
                    i(d, r),
                    h(t, m, r),
                    l(d, t, r)
                }
            }
        }
    }, {
        match: function(e) {
            if (e.is("input")) {
                var t = (" " + n(e, "type") + " ").toLowerCase()
                  , s = " color date datetime datetime-local email month number password search tel text time url week ";
                return s.indexOf(t) >= 0
            }
            return !1
        },
        apply: function(e) {
            var t = n(e, "type");
            return e.addClass(t),
            {
                remove: function() {
                    e.removeClass(t)
                },
                update: p
            }
        }
    }, {
        match: function(e) {
            return e.is(":radio")
        },
        apply: function(t, r) {
            var u, f, d;
            return u = c(t, r, {
                divClass: r.radioClass
            }),
            f = u.div,
            d = u.span,
            a(t, f, r),
            s(t, r, {
                "click touchend": function() {
                    e.uniform.update(e(':radio[name="' + n(t, "name") + '"]'))
                }
            }),
            o(d, t, r),
            {
                remove: w(t, r),
                update: function() {
                    i(f, r),
                    o(d, t, r),
                    l(f, t, r)
                }
            }
        }
    }, {
        match: function(e) {
            return e.is("select") && !m(e) ? !0 : !1
        },
        apply: function(t, n) {
            var r, o, u, f;
            return n.selectAutoWidth && b(t, function() {
                f = t.width()
            }),
            r = c(t, n, {
                divClass: n.selectClass,
                spanHtml: (t.find(":selected:first") || t.find("option:first")).html(),
                spanWrap: "before"
            }),
            o = r.div,
            u = r.span,
            n.selectAutoWidth ? b(t, function() {
                var e;
                e = u.outerWidth() - u.width(),
                o.width(f + e),
                u.width(f)
            }) : o.addClass("fixedWidth"),
            a(t, o, n),
            s(t, n, {
                change: function() {
                    u.html(t.find(":selected").html()),
                    o.removeClass(n.activeClass)
                },
                "click touchend": function() {
                    var e = t.find(":selected").html();
                    u.html() !== e && t.trigger("change")
                },
                keyup: function() {
                    u.html(t.find(":selected").html())
                }
            }),
            v(u, n),
            {
                remove: function() {
                    return u.remove(),
                    t.unwrap().unbind(n.eventNamespace),
                    t
                },
                update: function() {
                    n.selectAutoWidth ? (e.uniform.restore(t),
                    t.uniform(n)) : (i(o, n),
                    u.html(t.find(":selected").html()),
                    l(o, t, n))
                }
            }
        }
    }, {
        match: function(e) {
            return e.is("select") && m(e) ? !0 : !1
        },
        apply: function(e, t) {
            return e.addClass(t.selectMultiClass),
            {
                remove: function() {
                    e.removeClass(t.selectMultiClass)
                },
                update: p
            }
        }
    }, {
        match: function(e) {
            return e.is("textarea")
        },
        apply: function(e, t) {
            return e.addClass(t.textareaClass),
            {
                remove: function() {
                    e.removeClass(t.textareaClass)
                },
                update: p
            }
        }
    }];
    e.browser.msie && 7 > e.browser.version && (y = !1),
    e.uniform = {
        defaults: {
            activeClass: "active",
            autoHide: !0,
            buttonClass: "button",
            checkboxClass: "checker",
            checkedClass: "checked",
            disabledClass: "disabled",
            eventNamespace: ".uniform",
            fileButtonClass: "action",
            fileButtonHtml: "Choose File",
            fileClass: "uploader",
            fileDefaultHtml: "No file selected",
            filenameClass: "filename",
            focusClass: "focus",
            hoverClass: "hover",
            idPrefix: "uniform",
            radioClass: "radio",
            resetDefaultHtml: "Reset",
            resetSelector: !1,
            selectAutoWidth: !0,
            selectClass: "selector",
            selectMultiClass: "uniform-multiselect",
            submitDefaultHtml: "Submit",
            textareaClass: "uniform",
            useID: !0
        },
        elements: []
    },
    e.fn.uniform = function(t) {
        var n = this;
        return t = e.extend({}, e.uniform.defaults, t),
        g || (g = !0,
        f() && (y = !1)),
        y ? (t.resetSelector && e(t.resetSelector).mouseup(function() {
            window.setTimeout(function() {
                e.uniform.update(n)
            }, 10)
        }),
        this.each(function() {
            var n, s, a, i = e(this);
            if (i.data("uniformed"))
                return e.uniform.update(i),
                void 0;
            for (n = 0; k.length > n; n += 1)
                if (s = k[n],
                s.match(i, t))
                    return a = s.apply(i, t),
                    i.data("uniformed", a),
                    e.uniform.elements.push(i.get(0)),
                    void 0
        })) : this
    }
    ,
    e.uniform.restore = e.fn.uniform.restore = function(n) {
        n === t && (n = e.uniform.elements),
        e(n).each(function() {
            var t, n, s = e(this);
            n = s.data("uniformed"),
            n && (n.remove(),
            t = e.inArray(this, e.uniform.elements),
            t >= 0 && e.uniform.elements.splice(t, 1),
            s.removeData("uniformed"))
        })
    }
    ,
    e.uniform.update = e.fn.uniform.update = function(n) {
        n === t && (n = e.uniform.elements),
        e(n).each(function() {
            var t, n = e(this);
            t = n.data("uniformed"),
            t && t.update(n, t.options)
        })
    }
}
)(jQuery);
