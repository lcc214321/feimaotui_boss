if ("undefined" == typeof jQuery) throw new Error("AdminLTE requires jQuery");
+function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var i = e(this), s = i.data(n);
            if (!s) {
                var r = e.extend({}, o, i.data(), "object" == typeof t && t);
                i.data(n, s = new a(r))
            }
            if ("string" == typeof t) {
                if ("undefined" == typeof s[t]) throw new Error("No method named " + t);
                s[t]()
            }
        })
    }

    var n = "lte.layout", o = {slimscroll: !0, resetHeight: !0}, i = {
        wrapper: ".wrapper",
        contentWrapper: ".content-wrapper",
        layoutBoxed: ".layout-boxed",
        mainFooter: ".main-footer",
        mainHeader: ".main-header",
        sidebar: ".sidebar",
        controlSidebar: ".control-sidebar",
        fixed: ".fixed",
        sidebarMenu: ".sidebar-menu",
        logo: ".main-header .logo"
    }, s = {fixed: "fixed", holdTransition: "hold-transition"}, a = function (e) {
        this.options = e, this.bindedResize = !1, this.activate()
    };
    a.prototype.activate = function () {
        this.fix(), this.fixSidebar(), e("body").removeClass(s.holdTransition), this.options.resetHeight && e("body, html, " + i.wrapper).css({
            height: "auto",
            "min-height": "100%"
        }), this.bindedResize || (e(window).resize(function () {
            this.fix(), this.fixSidebar(), e(i.logo + ", " + i.sidebar).one("webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend", function () {
                this.fix(), this.fixSidebar()
            }.bind(this))
        }.bind(this)), this.bindedResize = !0), e(i.sidebarMenu).on("expanded.tree", function () {
            this.fix(), this.fixSidebar()
        }.bind(this)), e(i.sidebarMenu).on("collapsed.tree", function () {
            this.fix(), this.fixSidebar()
        }.bind(this))
    }, a.prototype.fix = function () {
        e(i.layoutBoxed + " > " + i.wrapper).css("overflow", "hidden");
        var t = e(i.mainFooter).outerHeight() || 0, n = e(i.mainHeader).outerHeight() + t, o = e(window).height(), a = e(i.sidebar).height() || 0;
        if (e("body").hasClass(s.fixed)) e(i.contentWrapper).css("min-height", o - t); else {
            var r;
            o >= a ? (e(i.contentWrapper).css("min-height", o - n), r = o - n) : (e(i.contentWrapper).css("min-height", a), r = a);
            var d = e(i.controlSidebar);
            "undefined" != typeof d && d.height() > r && e(i.contentWrapper).css("min-height", d.height())
        }
    }, a.prototype.fixSidebar = function () {
        return e("body").hasClass(s.fixed) ? void (this.options.slimscroll && "undefined" != typeof e.fn.slimScroll && (e(i.sidebar).slimScroll({destroy: !0}).height("auto"), e(i.sidebar).slimScroll({
            height: e(window).height() - e(i.mainHeader).height() + "px",
            color: "rgba(0,0,0,0.2)",
            size: "3px"
        }))) : void ("undefined" != typeof e.fn.slimScroll && e(i.sidebar).slimScroll({destroy: !0}).height("auto"))
    };
    var r = e.fn.layout;
    e.fn.layout = t, e.fn.layout.Constuctor = a, e.fn.layout.noConflict = function () {
        return e.fn.layout = r, this
    }, e(window).on("load", function () {
        t.call(e("body"))
    })
}(jQuery) + function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var i = e(this), s = i.data(n);
            if (!s) {
                var a = e.extend({}, o, i.data(), "object" == typeof t && t);
                i.data(n, s = new r(a))
            }
            "toggle" == t && s.toggle()
        })
    }

    var n = "lte.pushmenu", o = {
        collapseScreenSize: 767,
        expandOnHover: !1,
        expandTransitionDelay: 200
    }, i = {
        collapsed: ".sidebar-collapse",
        open: ".sidebar-open",
        mainSidebar: ".main-sidebar",
        contentWrapper: ".content-wrapper",
        searchInput: ".sidebar-form .form-control",
        button: '[data-toggle="push-menu"]',
        mini: ".sidebar-mini",
        expanded: ".sidebar-expanded-on-hover",
        layoutFixed: ".fixed"
    }, s = {
        collapsed: "sidebar-collapse",
        open: "sidebar-open",
        mini: "sidebar-mini",
        expanded: "sidebar-expanded-on-hover",
        expandFeature: "sidebar-mini-expand-feature",
        layoutFixed: "fixed"
    }, a = {expanded: "expanded.pushMenu", collapsed: "collapsed.pushMenu"}, r = function (e) {
        this.options = e, this.init()
    };
    r.prototype.init = function () {
        (this.options.expandOnHover || e("body").is(i.mini + i.layoutFixed)) && (this.expandOnHover(), e("body").addClass(s.expandFeature)), e(i.contentWrapper).click(function () {
            e(window).width() <= this.options.collapseScreenSize && e("body").hasClass(s.open) && this.close()
        }.bind(this)), e(i.searchInput).click(function (e) {
            e.stopPropagation()
        })
    }, r.prototype.toggle = function () {
        var t = e(window).width(), n = !e("body").hasClass(s.collapsed);
        t <= this.options.collapseScreenSize && (n = e("body").hasClass(s.open)), n ? this.close() : this.open()
    }, r.prototype.open = function () {
        var t = e(window).width();
        t > this.options.collapseScreenSize ? e("body").removeClass(s.collapsed).trigger(e.Event(a.expanded)) : e("body").addClass(s.open).trigger(e.Event(a.expanded))
    }, r.prototype.close = function () {
        var t = e(window).width();
        t > this.options.collapseScreenSize ? e("body").addClass(s.collapsed).trigger(e.Event(a.collapsed)) : e("body").removeClass(s.open + " " + s.collapsed).trigger(e.Event(a.collapsed))
    }, r.prototype.expandOnHover = function () {
        e(i.mainSidebar).hover(function () {
            e("body").is(i.mini + i.collapsed) && e(window).width() > this.options.collapseScreenSize && this.expand()
        }.bind(this), function () {
            e("body").is(i.expanded) && this.collapse()
        }.bind(this))
    }, r.prototype.expand = function () {
        setTimeout(function () {
            e("body").removeClass(s.collapsed).addClass(s.expanded)
        }, this.options.expandTransitionDelay)
    }, r.prototype.collapse = function () {
        setTimeout(function () {
            e("body").removeClass(s.expanded).addClass(s.collapsed)
        }, this.options.expandTransitionDelay)
    };
    var d = e.fn.pushMenu;
    e.fn.pushMenu = t, e.fn.pushMenu.Constructor = r, e.fn.pushMenu.noConflict = function () {
        return e.fn.pushMenu = d, this
    }, e(document).on("click", i.button, function (n) {
        n.preventDefault(), t.call(e(this), "toggle")
    }), e(window).on("load", function () {
        t.call(e(i.button))
    })
}(jQuery) + function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var i = e(this), s = i.data(n);
            if (!s) {
                var a = e.extend({}, o, i.data(), "object" == typeof t && t);
                i.data(n, new r(i, a))
            }
        })
    }

    var n = "lte.tree", o = {
        animationSpeed: 100,
        accordion: !0,
        followLink: !1,
        trigger: ".treeview a"
    }, i = {
        tree: ".tree",
        treeview: ".treeview",
        treeviewMenu: ".treeview-menu",
        open: ".menu-open, .active",
        li: "li",
        data: '[data-widget="tree"]',
        active: ".active"
    }, s = {open: "menu-open", tree: "tree", active: "active"}, a = {
        collapsed: "collapsed.tree",
        expanded: "expanded.tree"
    }, r = function (t, n) {
        this.element = t, this.options = n, e(this.element).addClass(s.tree), e(i.treeview + i.active, this.element).addClass(s.open), this._setUpListeners()
    };
    r.prototype.toggle = function (e, t) {
        var n = e.next(i.treeviewMenu), o = e.parent(), a = o.hasClass(s.open);
        o.is(i.treeview) && (this.options.followLink && "#" != e.attr("href") || t.preventDefault(), a ? this.collapse(n, o) : this.expand(n, o))
    }, r.prototype.expand = function (t, n) {
        var o = e.Event(a.expanded);
        if (this.options.accordion) {
            var r = n.siblings(i.open), d = r.children(i.treeviewMenu);
            this.collapse(d, r)
        }
        n.addClass(s.open), t.slideDown(this.options.animationSpeed, function () {
            e(this.element).trigger(o)
        }.bind(this))
    }, r.prototype.collapse = function (t, n) {
        var o = e.Event(a.collapsed);
        t.find(i.open).removeClass(s.open), n.removeClass(s.open), t.slideUp(this.options.animationSpeed, function () {
            t.find(i.open + " > " + i.treeview).slideUp(), e(this.element).trigger(o)
        }.bind(this))
    }, r.prototype._setUpListeners = function () {
        var t = this;
        e(this.element).on("click", this.options.trigger, function (n) {
            t.toggle(e(this), n);
            var o = e(this).parent();
            o.parent().is(i.treeviewMenu) && e(i.treeviewMenu + " > " + i.li + i.active).removeClass(s.active), o.parent().is(i.tree) && e(i.tree + " > " + i.li + i.active).removeClass(s.active), o && e(o).addClass(s.active)
        })
    };
    var d = e.fn.tree;
    e.fn.tree = t, e.fn.tree.Constructor = r, e.fn.tree.noConflict = function () {
        return e.fn.tree = d, this
    }, e(window).on("load", function () {
        e(i.data).each(function () {
            t.call(e(this))
        })
    })
}(jQuery) + function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var i = e(this), s = i.data(n);
            if (!s) {
                var a = e.extend({}, o, i.data(), "object" == typeof t && t);
                i.data(n, s = new r(i, a))
            }
            "string" == typeof t && s.toggle()
        })
    }

    var n = "lte.controlsidebar", o = {slide: !0}, i = {
        sidebar: ".control-sidebar",
        data: '[data-toggle="control-sidebar"]',
        open: ".control-sidebar-open",
        bg: ".control-sidebar-bg",
        wrapper: ".wrapper",
        content: ".content-wrapper",
        boxed: ".layout-boxed"
    }, s = {open: "control-sidebar-open", fixed: "fixed"}, a = {
        collapsed: "collapsed.controlsidebar",
        expanded: "expanded.controlsidebar"
    }, r = function (e, t) {
        this.element = e, this.options = t, this.hasBindedResize = !1, this.init()
    };
    r.prototype.init = function () {
        e(this.element).is(i.data) || e(this).on("click", this.toggle), this.fix(), e(window).resize(function () {
            this.fix()
        }.bind(this))
    }, r.prototype.toggle = function (t) {
        t && t.preventDefault(), this.fix(), e(i.sidebar).is(i.open) || e("body").is(i.open) ? this.collapse() : this.expand()
    }, r.prototype.expand = function () {
        this.options.slide ? e(i.sidebar).addClass(s.open) : e("body").addClass(s.open), e(this.element).trigger(e.Event(a.expanded))
    }, r.prototype.collapse = function () {
        e("body, " + i.sidebar).removeClass(s.open), e(this.element).trigger(e.Event(a.collapsed))
    }, r.prototype.fix = function () {
        e("body").is(i.boxed) && this._fixForBoxed(e(i.bg))
    }, r.prototype._fixForBoxed = function (t) {
        t.css({position: "absolute", height: e(i.wrapper).height()})
    };
    var d = e.fn.controlSidebar;
    e.fn.controlSidebar = t, e.fn.controlSidebar.Constructor = r, e.fn.controlSidebar.noConflict = function () {
        return e.fn.controlSidebar = d, this
    }, e(document).on("click", i.data, function (n) {
        n && n.preventDefault(), t.call(e(this), "toggle")
    })
}(jQuery) + function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var i = e(this), s = i.data(n);
            if (!s) {
                var a = e.extend({}, o, i.data(), "object" == typeof t && t);
                i.data(n, s = new r(i, a))
            }
            if ("string" == typeof t) {
                if ("undefined" == typeof s[t]) throw new Error("No method named " + t);
                s[t]()
            }
        })
    }

    var n = "lte.boxwidget", o = {
        animationSpeed: 100,
        collapseTrigger: '[data-widget="collapse"]',
        removeTrigger: '[data-widget="remove"]',
        collapseIcon: "fa-minus",
        expandIcon: "fa-plus",
        removeIcon: "fa-times"
    }, i = {
        data: ".box",
        collapsed: ".collapsed-box",
        body: ".box-body",
        footer: ".box-footer",
        tools: ".box-tools"
    }, s = {collapsed: "collapsed-box"}, a = {
        collapsed: "collapsed.boxwidget",
        expanded: "expanded.boxwidget",
        removed: "removed.boxwidget"
    }, r = function (e, t) {
        this.element = e, this.options = t, this._setUpListeners()
    };
    r.prototype.toggle = function () {
        var t = !e(this.element).is(i.collapsed);
        t ? this.collapse() : this.expand()
    }, r.prototype.expand = function () {
        var t = e.Event(a.expanded), n = this.options.collapseIcon, o = this.options.expandIcon;
        e(this.element).removeClass(s.collapsed), e(this.element).find(i.tools).find("." + o).removeClass(o).addClass(n), e(this.element).find(i.body + ", " + i.footer).slideDown(this.options.animationSpeed, function () {
            e(this.element).trigger(t)
        }.bind(this))
    }, r.prototype.collapse = function () {
        var t = e.Event(a.collapsed), n = this.options.collapseIcon, o = this.options.expandIcon;
        e(this.element).find(i.tools).find("." + n).removeClass(n).addClass(o), e(this.element).find(i.body + ", " + i.footer).slideUp(this.options.animationSpeed, function () {
            e(this.element).addClass(s.collapsed), e(this.element).trigger(t)
        }.bind(this))
    }, r.prototype.remove = function () {
        var t = e.Event(a.removed);
        e(this.element).slideUp(this.options.animationSpeed, function () {
            e(this.element).trigger(t), e(this.element).remove()
        }.bind(this))
    }, r.prototype._setUpListeners = function () {
        var t = this;
        e(this.element).on("click", this.options.collapseTrigger, function (e) {
            e && e.preventDefault(), t.toggle()
        }), e(this.element).on("click", this.options.removeTrigger, function (e) {
            e && e.preventDefault(), t.remove()
        })
    };
    var d = e.fn.boxWidget;
    e.fn.boxWidget = t, e.fn.boxWidget.Constructor = r, e.fn.boxWidget.noConflict = function () {
        return e.fn.boxWidget = d, this
    }, e(window).on("load", function () {
        e(i.data).each(function () {
            t.call(e(this))
        })
    })
}(jQuery) + function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var i = e(this), s = i.data(n);
            if (!s) {
                var r = e.extend({}, o, i.data(), "object" == typeof t && t);
                i.data(n, s = new a(i, r))
            }
            if ("string" == typeof s) {
                if ("undefined" == typeof s[t]) throw new Error("No method named " + t);
                s[t]()
            }
        })
    }

    var n = "lte.todolist", o = {
        iCheck: !1, onCheck: function () {
        }, onUnCheck: function () {
        }
    }, i = {data: '[data-widget="todo-list"]'}, s = {done: "done"}, a = function (e, t) {
        this.element = e, this.options = t, this._setUpListeners()
    };
    a.prototype.toggle = function (e) {
        return e.parents(i.li).first().toggleClass(s.done), e.prop("checked") ? void this.check(e) : void this.unCheck(e)
    }, a.prototype.check = function (e) {
        this.options.onCheck.call(e)
    }, a.prototype.unCheck = function (e) {
        this.options.onUnCheck.call(e)
    }, a.prototype._setUpListeners = function () {
        var t = this;
        e(this.element).on("change ifChanged", "input:checkbox", function () {
            t.toggle(e(this))
        })
    };
    var r = e.fn.todoList;
    e.fn.todoList = t, e.fn.todoList.Constructor = a, e.fn.todoList.noConflict = function () {
        return e.fn.todoList = r, this
    }, e(window).on("load", function () {
        e(i.data).each(function () {
            t.call(e(this))
        })
    })
}(jQuery) + function (e) {
    "use strict";
    function t(t) {
        return this.each(function () {
            var o = e(this), i = o.data(n);
            i || o.data(n, i = new s(o)), "string" == typeof t && i.toggle(o)
        })
    }

    var n = "lte.directchat", o = {
        data: '[data-widget="chat-pane-toggle"]',
        box: ".direct-chat"
    }, i = {open: "direct-chat-contacts-open"}, s = function (e) {
        this.element = e
    };
    s.prototype.toggle = function (e) {
        e.parents(o.box).first().toggleClass(i.open)
    };
    var a = e.fn.directChat;
    e.fn.directChat = t, e.fn.directChat.Constructor = s, e.fn.directChat.noConflict = function () {
        return e.fn.directChat = a, this
    }, e(document).on("click", o.data, function (n) {
        n && n.preventDefault(), t.call(e(this), "toggle")
    })
}(jQuery);